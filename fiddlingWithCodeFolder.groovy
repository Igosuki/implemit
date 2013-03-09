import org.geps.struct.Hashtable

Hashtable myTable = new Hashtable()

myTable.put("Ololzorlol", new Integer(150000))
def entries = myTable.entries()
println entries.size()
for(Hashtable.Entry e : entries) {
    println e.val
}