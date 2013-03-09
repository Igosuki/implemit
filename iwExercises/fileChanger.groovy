import java.util.regex.Pattern
import java.io.File

File rootDir
if(args)     
    rootDir = new File(args[0])
else 
    rootDir = new File("N:\\JapAnime\\One Piece\\500-600")
class FileChanger {
    
    def from
    def to
    
    FileChanger(from, to) {
       this.from = from         
       this.to = to
    }
    
    def replaceFileNames(File root) {
        if(root.isDirectory()) {
            def files = root.listFiles()
            if(files) {
                files.each  {
                    replaceFileNames(it)
                }
            }
        } else {
            if(root.name ==~ from) {
                def replace = root.name.replaceAll(from, to)
                println "Renaming file $root.name to : $replace"
                if(replace)
                    root.renameTo(new File(root.parent+"/"+replace)) 
            }
        }
    }
}

Pattern from = ~/(\[[a-zA-Z\-]+\])+(\s*[_\-]*)(.*)(\.[a-z]{0,4})/
String to = '$3$2$1$4'
rootDir?.listFiles().each {
    if(it.name ==~ from){
        println it.path
        println it.parent
        println it.name.replaceAll(from, to)
    }
}

def chg = new FileChanger(from, to)
chg.replaceFileNames(rootDir)
rootDir.listFiles()

