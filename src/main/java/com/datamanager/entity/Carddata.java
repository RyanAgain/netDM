package com.datamanager.entity;

/**
 * 2018-04-11-23:45 Author By AgainP
 */
public class Carddata {
    private long cardId;

    private String cardName;

    private int cardState;

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardState() {
        return cardState;
    }

    public void setCardState(int cardState) {
        this.cardState = cardState;
    }

    @Override
    public String toString() {
        return "Carddata{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                ", cardState=" + cardState +
                '}';
    }
}
