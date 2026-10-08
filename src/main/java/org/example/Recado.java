package org.example;

public class Recado {
    private final int id;
    private final String autor;
    private final String menssagem;

    public Recado(int id, String autor, String menssagem) {
        this.id = id;
        this.autor = autor;
        this.menssagem = menssagem;
    }

    public int getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public String paraJson(){
        return "{\"id\":" + id
                + ",\"autor\":\"" + escapar(autor)
                + "\", \"menssagem\":\"" + escapar(menssagem) + "\"}";
    }

    private String escapar(String texto){
        return texto.replace("\\","\\\\")
                .replace("\"","\\\"")
                .replace("\r","")
                .replace("\n", "\\n");
    }
}

