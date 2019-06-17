export class CreditCard{
    
    public cardNumber: String;
    public bankName: String;
    public expiryDate: String;

    constructor(bankName? : string, cardNumber? : string, expiryDate? : String){
        this.cardNumber = cardNumber;
        this.bankName = bankName;
        this.expiryDate = expiryDate;
    }

}