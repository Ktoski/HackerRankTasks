package EncryptionTask;

import org.junit.Assert;
import org.junit.Test;

public class EncryptionTest {

    @Test
    public void test1(){

        Message mes = new Message("have a nice day");
        Assert.assertEquals("hae and via ecy", mes.transformToEncodedMessage());

        Message mes2 = new Message("feed the dog");
        Assert.assertEquals("fto ehg ee dd", mes2.transformToEncodedMessage());

        Message mes3 = new Message("chillout");
        Assert.assertEquals("clu hlt io", mes3.transformToEncodedMessage());

        Message mes4 = new Message("wclwfoznbmyycxvaxagjhtexdkwjqhlojykopldsxesbbnezqmixfpujbssrbfhlgubvfhpfliimvmnny");
        Assert.assertEquals("wmgjpnull cyjqlejgi lyhhdzbui wctlsqsbm fxeoxmsvv ovxjeirfm zadysxbhn nxkkbffpn bawobphfy", mes4.transformToEncodedMessage());

    }

}
