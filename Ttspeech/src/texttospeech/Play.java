/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttospeech;

import javax.speech.synthesis.Voice;

/**
 *
 * @author 500040332
 */
public class Play extends Thread{
    //audiobookUI abc;
    Speaking abc;
   String speak; Voice  voicename;
    public Play( Speaking abc,String speak,Voice  voicename)
    {
    this.abc=abc;
    this.speak=speak;
    this.voicename=voicename;
    }
    
    
    
    @Override
    public void run() {
      abc.dospeak(speak, voicename);
    }

    
}
