package ar.edu.unahur.obj2;

import java.util.List;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;


public class FyleSystemTest {
	Archivo txt = new Archivo("notas", 250, ".txt");
	Archivo mp3 = new Archivo("Rock", 400, ".mp3");
	Archivo img = new Archivo("Foto1", 600, ".jpg");
	Archivo video = new Archivo("Video1", 450, ".mp4");
	Carpeta sub1 = new Carpeta("Sub1", List.of(txt));
	Carpeta sub2 = new Carpeta("Sub2", List.of(mp3,img));
	Carpeta root = new Carpeta("root", List.of(sub1,sub2,video));

    @Test
    void dataUnaCapertaQueContineSubCarpetas_ObtengoElTamanioTotal() {
        assertEquals(1700, root.tamanio());
        assertEquals(250, sub1.tamanio());
        assertEquals(1000, sub2.tamanio());
    }
    
    @Test
    void dataUnaCapertaQueContineSubCarpetas_ObtengoElArchivoMasPesado() {
        assertEquals(img, root.archivoMasPesado());
        assertTrue(img.tamanio().equals(600));
        assertEquals("Foto1.jpg", img.nombre());
    }
}
