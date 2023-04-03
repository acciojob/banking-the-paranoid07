package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000.0);
        if(balance < getMinBalance()){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId=tradeLicenseId;

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if(! isVlid(tradeLicenseId)){

            String rearrangeId=arrangeId(tradeLicenseId);

            if(rearrangeId == ""){
                throw new Exception("Valid License can not be generated");
            }
            else{
                this.tradeLicenseId=rearrangeId;
            }
        }


    }
    public boolean isVlid(String tradeLicenseId){

        for(int i = 0; i < tradeLicenseId.length() - 1; i++){
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i+1))
                return false;
        }
        return true;
    }

    public String arrangeId(String S){
        int N=S.length();

        int freq[]=new int[26];

        for(int i = 0; i < N;i++ ){
            freq[S.charAt(i) - 'A']++;
        }

        char ch_max =getCountChar(freq);
        int max_count=freq[ch_max - 'A'];



        if(N % 2 == 0 && max_count > (N/2)+1){
            return  "";
        }else if(max_count > (N/2)+2){
            return "";
        }


        char ans[]=new char[N];

        //fiing max character at alternate places
        int index =0;
        for( index=0; index < N ; index+=2){
            if(freq[ch_max - 'A'] > 0){
                ans[index]=ch_max;
                freq[ch_max - 'A']--;
            }
        }

        //fiing other characters

        for(int i=0;i<26;i++){

            while(freq[i] > 0){

                if(index >= N){
                    index=1;
                }
                ans[index]=(char)('A'+i);
                freq[i]--;
                index+=2;
            }
        }

        StringBuilder rearranged=new StringBuilder();
        for(int i=0;i<N;i++){
            rearranged.append(ans[i]);
        }
        return rearranged.toString();




    }

    public char getCountChar(int freq[]){
        int maxFreq=Integer.MIN_VALUE;
        char ch_max=0;

        for(int i=0;i<26;i++){
            if(freq[i] > maxFreq){
                maxFreq=freq[i];
                ch_max=(char)('A'+i);
            }
        }
        return ch_max;
    }


}
