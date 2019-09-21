package EncryptionTask;

public class Message {

    private String messageContent;
    private int floor;
    private int ceeling;
    private char[][] finalGrid;

    public Message(String messageContent){
        this.messageContent = messageContent;
        removeSpaces();
        floor = (int) Math.floor(Math.sqrt(messageContent.length()));
        ceeling = (int) Math.ceil(Math.sqrt(messageContent.length()));
    }

    private void removeSpaces(){
        this.messageContent = this.messageContent.trim().replace(" ","");
    }

    private void transformToEncodedArray(){

        ensureMultiplyas();
        this.finalGrid = new char[this.floor][this.ceeling];
        char[] messageAsCharArray = this.messageContent.toCharArray();
        int count = 0;
        for(int i = 0; i < this.floor; i++){
            for (int j = 0; j < this.ceeling; j++){
                if(count == this.messageContent.length()) {
                    break;
                }
                this.finalGrid[i][j] = messageAsCharArray[count];
                count++;
            }
        }
    }

    String transformToEncodedMessage(){
        transformToEncodedArray();
        for(int i = 0; i < this.floor; i++) {
            System.out.println();
            for (int j = 0; j < this.ceeling; j++) {
                System.out.print(" " + this.finalGrid[i][j]);
            }
        }

        StringBuilder encodedMessage = new StringBuilder();

        for(int i = 0; i < this.ceeling; i++) {
            for (int j = 0; j < this.floor; j++) {
                char currentLetter = this.finalGrid[j][i];
                if( !(currentLetter == 0))
                    encodedMessage.append(this.finalGrid[j][i]);

            }
            encodedMessage.append(" ");
        }
        return encodedMessage.toString().trim();
    }

    private void ensureMultiplyas(){
        int res = this.floor * this.ceeling;
        if(res < this.messageContent.length()) {
            ++this.floor;
            res = this.floor * this.ceeling;
            if(res < this.messageContent.length()) {
                throw new IllegalArgumentException("Incorrect array size");
            }
        }

    }
}
