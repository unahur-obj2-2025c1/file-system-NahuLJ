package ar.edu.unahur.obj2;

import java.util.Comparator;
import java.util.List;

public class FileSystem {
	private List<IElemento> archivos;
	
	public FileSystem(List<IElemento> archivos) {
		this.archivos = archivos;
	}
	
	public Integer tamanioTotal() {
		return archivos.stream().mapToInt(archivo -> archivo.tamanio()).sum();
	}
	
	public IElemento archivoMasPesado() {
		return archivos.stream().map(archivo -> archivo.archivoMasPesado())
				.max(Comparator.comparingInt(archivo -> archivo.tamanio())).orElseThrow();
	}
	
}
