package ar.edu.unahur.obj2;

import java.util.Comparator;
import java.util.List;

public class Carpeta implements IElemento{
	private String nombre;
	private List<IElemento> archivos;
	
	public Carpeta(String nombre, List<IElemento> archivos) {
		this.nombre = nombre;
		this.archivos = archivos;
	}
	
	@Override
	public String nombre() {
		return nombre;
	}

	@Override
	public Integer tamanio() {
		return archivos.stream().mapToInt(archivo -> archivo.tamanio()).sum();
	}

	@Override
	public void mostrar(Integer identacion) {
		System.out.println(" ".repeat(identacion) + "└ " + nombre + " (" + this.tamanio() + "-Bytes)");
		archivos.stream().forEach(a -> a.mostrar(identacion + 3));
	}

	@Override
	public IElemento archivoMasPesado() {
		return archivos.stream().map(archivo -> archivo.archivoMasPesado())
				.max(Comparator.comparingInt(archivo -> archivo.tamanio())).orElseThrow();
	}

}
