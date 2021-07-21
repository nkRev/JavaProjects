package fixtures;

abstract class Fixture {
	protected String name;
	protected String shortDescription;
	protected String longDescription;

	// default no arg
	public Fixture() {

	}

	/**
	 * Constructor to build Fixture object
	 * 
	 * @param name             title for fixtures
	 * @param shortDescription one sentence description of a picture.
	 * @param longDescription  a paragraph long description of the fixture.
	 *                         displayed when player investigates fixture.
	 */
	public Fixture(String name, String shortDescription, String longDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	protected String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public String toString() {
		return String.format("Name: %s\nDescription: %s, %s\n", name, shortDescription, longDescription);
	}

}
