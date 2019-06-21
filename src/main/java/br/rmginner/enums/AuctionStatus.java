package br.rmginner.enums;

public enum AuctionStatus {
    CLOSED("CL", "Closed"),
    OPENED("OP", "Opened");

    private String code;
    private String label;

    AuctionStatus(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
