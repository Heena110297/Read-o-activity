/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttospeech;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.speech.AudioException;
import javax.speech.EngineException;

/**
 *
 * @author 500040332
 */
public class One extends Thread {
    Speaking abc;
    public One(Speaking abc)
    {
        this.abc = abc ;
    }
    public void run()
    {
        try {
            abc.ru_n();
        } catch (AudioException ex) {
            Logger.getLogger(One.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EngineException ex) {
            Logger.getLogger(One.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(One.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
