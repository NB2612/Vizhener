package org.example;

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


    public String encrypt() {
        if (Valitade()){
            String result = "";
            for (int i = 0, len = this.text.length(); i < len; i++) {
            /*Шифрование методом Виженера производится по формуле:
            Ci = (Pi + Ki) mod N
            где ci – символ закодированного сообщения, pi – символ исходного сообщения, ki – символ ключа,
            N – мощность алфавита (количество символов в алфавите).
             */
                int c = (ABC.indexOf(this.text.charAt(i)) + ABC.indexOf(key.charAt(i))) % ABC.length();
                result += ABC.charAt(c);
            }
            return result;
        } else {return null;}
    }
    public String decrypt() {
        if (Valitade()){
            String result = "";
            for (int i = 0, len = this.text.length(); i < len; i++) {
                /*
                Расшифровка методом Виженера производится по формуле:
                Pi = (Ci + M - Ki) mod N
                где ci – символ закодированного сообщения, pi – символ исходного сообщения, ki – символ ключа,
                N – мощность алфавита (количество символов в алфавите).
                 */
                int c = (ABC.indexOf(this.text.charAt(i)) + ABC.length() - ABC.indexOf(key.charAt(i))) % ABC.length();
                result += ABC.charAt(c);
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
}
