/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttospeech;

import java.beans.PropertyVetoException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

/**
 *
 * @author 500040332
 */
public class Speaking {
    String speaktext;
    Voice v;
    SynthesizerModeDesc desc;
    public static Synthesizer synthesizer;
    public void dospeak(String speak,Voice  voicename)
	    {
	        speaktext=speak;
	        v = voicename;
                
                 
	        try
	        {
                    System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                   // System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
	             desc = new SynthesizerModeDesc(null,"general",  Locale.US,null,null);
                     /*Voice voice = new Voice(
                      "kevin16",              //name for this voice  
                      Voice.AGE_DONT_CARE,   //age for this voice
                      Voice.GENDER_FEMALE,//gender for this voice
                      null);
                    try {
                        synthesizer.getSynthesizerProperties().setVoice(voice);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(Speaking.class.getName()).log(Level.SEVERE, null, ex);
                    } */
	            synthesizer = Central.createSynthesizer(desc);
	            synthesizer.allocate();
	            synthesizer.resume();
                    synthesizer.getSynthesizerProperties().setVoice(voicename);
	            synthesizer.speakPlainText(speaktext,null);
                    
                    
	            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	            //synthesizer.deallocate();
	        }
	        catch(EngineException | IllegalArgumentException | AudioException | InterruptedException e)
	        {
	            String message = " missing speech.properties in " + System.getProperty("user.home") + "\n";
	            System.out.println(""+e);
	            System.out.println(message);
	        } catch (PropertyVetoException ex) {
            Logger.getLogger(Speaking.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    public void st_op() throws EngineException
    {
        synthesizer.pause();
        //synthesizer.deallocate();
    }
    public void change_speed(Float speed)
    {
        try {
            synthesizer.getSynthesizerProperties().setSpeakingRate(speed);
        } catch (PropertyVetoException ex) {
        }
    }
    public void change_pitch(Float pitch) throws PropertyVetoException
    {
        synthesizer.getSynthesizerProperties().setPitch(pitch);
        System.out.println(pitch);
    }
    public void ru_n() throws AudioException, EngineException,InterruptedException
    {
        try
        {
            
	            synthesizer.allocate();
	            synthesizer.resume();
                     synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            String message = " missing speech.properties in " + System.getProperty("user.home") + "\n";
	            System.out.println(""+e);
	            System.out.println(message);
        }
    }
}
