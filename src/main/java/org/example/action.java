package org.example;

import java.util.Random;

class Action {

    private String key;
    private String text;
    private final String ABC;

    public Action(){
        this.text = null; //
        this.key = null; //
        this.ABC = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuWwXxYyZz123456789:;/.,()-[]{}=+/<>&?|^%$#@! "; // алфавит
    }

    public void setKey(String newKey) {
        this.key = newKey;
        System.out.println("Key set success!");
    }

    public String getKey() {return this.key;}

    public String getText() {
        return this.text;
    }

    public void setText(String newText) {
        this.text = newText;
        System.out.println("Text set success!");
    }

    public void keyGen(int len){
        String key = "";
        Random r = new Random();
        for (int i = 0; i < len; i++){
            key += this.ABC.charAt(r.nextInt(0,59));
        }
        setKey(key);
        System.out.println("Key: " + key);
    }

    public String encrypt() {
        if (Valitade()){
            String result = "";
            String ExtKey = Key_Extension();
            for (int i = 0, c, len = this.text.length(); i < len; i++) {
            /*Шифрование методом Виженера производится по формуле:
            Ci = (Pi + Ki) mod N
            где ci – символ закодированного сообщения, pi – символ исходного сообщения, ki – символ ключа,
            N – мощность алфавита (количество символов в алфавите).
             */
                c = (this.ABC.indexOf(this.text.charAt(i)) + this.ABC.indexOf(ExtKey.charAt(i))) %
                        this.ABC.length();
                result += this.ABC.charAt(c);
            }
            return result;
        } else {return null;}
    }
    public String decrypt() {
        if (Valitade()){
            String result = "";
            String ExtKey = Key_Extension();
            for (int i = 0, c, len = this.text.length(); i < len; i++) {
                /*
                Расшифровка методом Виженера производится по формуле:
                Pi = (Ci + M - Ki) mod N
                где ci – символ закодированного сообщения, pi – символ исходного сообщения, ki – символ ключа,
                N – мощность алфавита (количество символов в алфавите).
                 */
                c = (this.ABC.indexOf(this.text.charAt(i)) +
                        this.ABC.length() - this.ABC.indexOf(ExtKey.charAt(i))) %
                        this.ABC.length();
                result += this.ABC.charAt(c);
            }
            return result;
        } else {return null;}
    }

    private boolean Valitade(){
        if (getKey() == null){
            if (getText() == null){
                System.out.println(Errors.Get_error(102));
            } else { System.out.println(Errors.Get_error(101)); }
            return false;
        } else {return true;}
    }

    private String Key_Extension() {
        String ExtKey = "";
        if (this.text.length() > this.key.length()){
            for (int i = 0, j = 0; i < this.text.length(); i++, j++){
                if (j == this.key.length()) j = 0;
                ExtKey += this.key.charAt(j);
            }
            return ExtKey;
        } else {
            return this.key;
        }
    }
}
