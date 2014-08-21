package zipeditor.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AarModelTest extends AbstractModelTest {

	@Override
	public String getArchiveName() {
		return "appcompat-v7-19.1.0.aar";
	}

	@Override
	public int getArchiveType() {
		return ZipModel.ZIP;
	}
	
	@Override
	@Test
	public void shouldOpenNodes() throws Exception {
		assertEquals(getArchiveType(), model.getType());
		assertEquals("AndroidManifest.xml", model.getRoot().getChildByName("AndroidManifest.xml", false).getName());
		assertEquals(null, model.getRoot().getChildByName("unknown", false));
	}
	

}
