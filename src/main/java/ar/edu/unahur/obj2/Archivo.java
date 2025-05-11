package ar.edu.unahur.obj2;

public class Archivo implements IElemento {
	private String nombre;
	private String extension;
	private Integer tamanio;
	
	public Archivo(String nombre, Integer tamanio, String extension) {
		this.nombre = nombre;
		this.extension = extension;
		this.tamanio = tamanio;
	}
	
	@Override
	public String nombre() {
		return nombre + extension;
	}

	@Override
	public Integer tamanio() {
		return tamanio;
	}

	@Override
	public void mostrar(Integer identacion) {
		System.out.println(" ".repeat(identacion) + "├ " + this.nombre());
	}

	@Override
	public IElemento archivoMasPesado() {
		return this;
	}

}
