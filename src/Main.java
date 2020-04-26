public class Main
{
    static final int ONE    = 0x01; //0000 0001
    static final int TWO    = 0x02; //0000 0010
    static final int THREE  = 0x04; //0000 0100
    static final int FOUR   = 0x08; //0000 1000
    static final int FIVE   = 0x10; //0001 0000
    static final int SIX    = 0x20; //0010 0000
    static final int SEVEN  = 0x40; //0100 0000
    static final int EIGHT  = 0x80; //1000 0000

    int hex1 = 0x0A; //0000 1010
    int hex2 = 0x0f; //0000 1111
    int hex3 = 0x0C; //0000 1100


    // & - умнажается на 0
    // 0000 0001                // 0000 0001
    // 0000 0001                // 0000 0000
    //----------                //----------
    // 0000 0001                // 0000 0000

    // | - считается по единице
    // 7654 3210
    // 0010 1001                // 0000 0001
    // 0010 0101                // 0000 0000
    // =========                // =========
    // 0010 1101                // 0000 0001

    public static void main(String[] args)
    {
        int receivedByte = 72;              // 0100 1000
        int testSuccess = 0x08 | 0x40;      // 0100 1000
        if(Compare(receivedByte, testSuccess)){
            System.out.println("Тест удовлетворительный");
        }
        else
            System.out.println("Тест неуд");
        //==========================================
        int ex = 16;
        int appendByte = 3;
        ex |= appendByte<<2; // 0001 0000 |= 0000 0011 << 2 = 0001 1100
        ex &= ~0x04; // 0001 1100 & 1111 1011
        System.out.println(ex);
        System.out.println(0xff);
    }

    static boolean Compare(int received, int mask)
    {
        return (received & mask) == mask;
    }
}
