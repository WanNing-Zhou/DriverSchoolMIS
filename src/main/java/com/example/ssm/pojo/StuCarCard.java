package com.example.ssm.pojo;

/**
 * @author 周万宁
 * @className StuCarCard
 * @create 2023/4/30-22:06
 * @description 练车卡
 */
public class StuCarCard {
    private int cardId;
    private String cardName; //卡名称
    private String cardNumber;
    private String cardCosume;
    private int stuId;
    private char cardState; //卡片状态

    public StuCarCard(int cardId, String cardName, String cardNumber, String cardCosume, int stuId, char cardState) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardCosume = cardCosume;
        this.stuId = stuId;
        this.cardState = cardState;
    }

    @Override
    public String toString() {
        return "StuCarCard{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardCosume='" + cardCosume + '\'' +
                ", stuId=" + stuId +
                ", cardState=" + cardState +
                '}';
    }

    public StuCarCard() {
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardCosume() {
        return cardCosume;
    }

    public void setCardCosume(String cardCosume) {
        this.cardCosume = cardCosume;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public char getCardState() {
        return cardState;
    }

    public void setCardState(char cardState) {
        this.cardState = cardState;
    }
}
