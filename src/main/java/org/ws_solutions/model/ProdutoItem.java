package org.ws_solutions.model;

public class ProdutoItem {
    private String id;
    private Produto produto;

    public ProdutoItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
