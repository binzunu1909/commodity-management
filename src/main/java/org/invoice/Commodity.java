package org.invoice;

public class Commodity {
    private String id;
    private String typeCommodity;

    public Commodity() {
    }

    public Commodity(String id, String typeCommodity) {
        this.id = id;
        this.typeCommodity = typeCommodity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeCommodity() {
        return typeCommodity;
    }

    public void setTypeCommodity(String typeCommodity) {
        this.typeCommodity = typeCommodity;
    }

    @Override
    public String toString() {
        return typeCommodity;
    }
}
