package creational.builder;

/**
 * 
 */
public class PartType2 implements Part{

	/**
	 * Cf Méthode surchargée
	 * @see creational.builder.Part#getContent()
	 * {@inheritDoc}
	 */
	@Override
	public Object getContent() {
		return "Part Type 2";
	}
}



