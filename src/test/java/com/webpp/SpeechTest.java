package com.webpp;

import org.testng.annotations.Test;
import java.util.Locale; 
import javax.speech.Central; 
import javax.speech.synthesis.Synthesizer; 
import javax.speech.synthesis.SynthesizerModeDesc; 
import com.webp.*;
public class SpeechTest extends Speech{
	
  @Test
  public void f() {
	  
	  selectBrowser("firefox");
		Initialize(driver);
		
		driver.get("https://dictation.io/speech");
		StartSpeech();
	
	  
	  
	  try {
	// set property as Kevin Dictionary 
      System.setProperty("freetts.voices", 
          "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");  
            
      // Register Engine 
      Central.registerEngineCentral 
          ("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral"); 

      // Create a Synthesizer 
      Synthesizer synthesizer =                                          
          Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));      

      // Allocate synthesizer 
      synthesizer.allocate();         
        
      // Resume Synthesizer 
      synthesizer.resume();     
        
      // speaks the given text until queue is empty. 
      synthesizer.speakPlainText("GeeksforGeeks", null);          
      synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY); 
        
      // Deallocate the Synthesizer. 
      synthesizer.deallocate();     
      StopSpeech();
      String s = getText();
      if(s.equals("GeeksforGeeks"))
    	  System.out.println("hurray");
      else
    	  System.out.println("NOOOO");
  }  
	  
		

  catch (Exception e)  
  { 
      e.printStackTrace(); 
  } 
  }
}
