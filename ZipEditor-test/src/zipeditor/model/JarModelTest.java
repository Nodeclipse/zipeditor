package zipeditor.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class JarModelTest extends AbstractModelTest {

	@Override
	public String getArchiveName() {
		return "android-support-v4.jar";
	}

	@Override
	public int getArchiveType() {
		return ZipModel.ZIP;
	}

	@Override
	@Test
	public void shouldOpenNodes() throws Exception {
		assertEquals(getArchiveType(), model.getType());
		assertEquals("MANIFEST.MF", model.getRoot().getChildByName("META-INF", false) //
				.getChildByName("MANIFEST.MF", false).getName());
		assertEquals(null, model.getRoot().getChildByName("unknown", false));
	}
	
}
