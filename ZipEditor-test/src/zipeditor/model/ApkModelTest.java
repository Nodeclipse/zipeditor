package zipeditor.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ApkModelTest extends AbstractModelTest {

	@Override
	public String getArchiveName() {
		return "2048.apk";
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
