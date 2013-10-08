package fr.renater.idegest.tu;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GestAjoutUsersTest {
	private GestAjoutUsers gau;                           

	@Before
	protected void setUp() throws Exception {
		try {
			this.gau = new GestAjoutUsers("testusers.xml");   
		} catch (IOException e) {
			fail("Création de l'OUT impossible !");
		}
	}

	@Test
	public void test2PremiersCarsGenUid() {
		String uid = this.gau.genUid("Bob", "Martin");                      
		assertTrue("Les 2 premiers caractères sont valides", uid.startsWith("bm"));  
	}
	
	@Test
	  public void test2PremiersCarsGenUidBis() {
	    String uid = this.gau.genUid("Bob", "Martin");                 
	    String premscar = uid.substring(0, 2);                         
	    assertEquals("Les 2 premiers caractères sont valides", "bm", premscar); 
	  }
	
	@Test
	public void testMinuscule(){
		String uid = this.gau.genUid("COCO", "RICO");
		String minuscule = uid.toLowerCase();
		assertEquals("Caractère minuscule","crico",minuscule);
	}
	
	@Test
	public void nombreCaractere(){
		String uid = this.gau.genUid("Haku", "NAMETAMTAZE");
		int taille = uid.length();
		if ((taille >4) && (taille < 10)){
			assertEquals("Il y a entre 5 et 8 caracs","hnametamta",uid);
		}
		else{
			assertEquals("Il y a plus de 10 caracs et moins de 5","hnametamta",uid);
		}
	}
}
