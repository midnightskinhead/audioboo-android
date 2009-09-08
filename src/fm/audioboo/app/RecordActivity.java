/**
 * This file is part of AudioBoo, an android program for audio blogging.
 * Copyright (C) 2009 BestBefore Media Ltd. All rights reserved.
 *
 * Author: Jens Finkhaeuser <jens@finkhaeuser.de>
 *
 * $Id$
 **/

package fm.audioboo.app;

import android.app.Activity;

import android.os.Bundle;

import android.content.res.Configuration;

import android.widget.ToggleButton;
import android.widget.CompoundButton;

import fm.audioboo.widget.RecordButton;

import android.util.Log;

/**
 * FIXME
 **/
public class RecordActivity extends Activity
{
  /***************************************************************************
   * Private constants
   **/
  // Log ID
  private static final String LTAG  = "RecordActivity";

  // Limit for the recording time we allow, in seconds.
  private static final int    RECORDING_TIME_LIMIT = 1200;


  /***************************************************************************
   * Data members
   **/
  private FLACRecorder mFlacRecorder;


  /***************************************************************************
   * Implementation
   **/
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
  }



  @Override
  public void onStart()
  {
    super.onStart();

    setContentView(R.layout.record);

    if (null == mFlacRecorder) {
      mFlacRecorder = new FLACRecorder();
      mFlacRecorder.start();
    }

    RecordButton tb = (RecordButton) findViewById(R.id.record_button);
    if (null != tb) {
      tb.setMax(RECORDING_TIME_LIMIT);

      tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
          if (isChecked) {
            Log.d(LTAG, "Resume recording!");
//            mFlacRecorder.resumeRecording();
          }
          else {
            Log.d(LTAG, "Pause recording!");
//            mFlacRecorder.pauseRecording();
          }
        }
      });
    }
  }



  @Override
  public void onConfigurationChanged(Configuration config)
  {
    // Ignore when the keyboard opens to the extent that we don't fetch boos
    // again.
    super.onConfigurationChanged(config);
  }



}
