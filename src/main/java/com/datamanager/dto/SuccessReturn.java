package com.datamanager.dto;

import com.datamanager.enums.ReturnEums;

/**
 * 2018-05-17-18:07 Author By AgainP
 */
public class SuccessReturn {
    private long cardId;

    private int returnState;

    private String returnInfo;

    private int cardState;

    public SuccessReturn(long cardId, ReturnEums returnEums) {
        this.cardId = cardId;
        this.returnState = returnEums.getState();
        this.returnInfo = returnEums.getStateInfo();
    }

    public SuccessReturn(long cardId, ReturnEums returnEums, int cardState) {
        this.cardId = cardId;
        this.returnState = returnEums.getState();
        this.returnInfo = returnEums.getStateInfo();
        this.cardState = cardState;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public int getCardState() {
        return cardState;
    }

    public void setCardState(int cardState) {
        this.cardState = cardState;
    }
}
