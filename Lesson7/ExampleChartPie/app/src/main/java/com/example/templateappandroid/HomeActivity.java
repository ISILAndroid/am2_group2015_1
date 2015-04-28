package com.example.templateappandroid;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends Activity {

	private static int[] COLORS = new int[] { Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN };
	private DefaultRenderer mRenderer = new DefaultRenderer();
	private GraphicalView mChartView;
	private CategorySeries mSeries = new CategorySeries("");
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
	    mRenderer.setZoomButtonsVisible(true);
	    mRenderer.setStartAngle(180);
	    mRenderer.setDisplayValues(true);
	    mRenderer.setClickEnabled(true);
	    
        addItem(0, 1);
        addItem(1, 1);
        addItem(2, 1);
        addItem(3, 1);
	    LinearLayout layout = (LinearLayout) findViewById(R.id.container);
	    mChartView = ChartFactory.getPieChartView(this, mSeries, mRenderer);
	    
	    layout.addView(mChartView, new LayoutParams(LayoutParams.FILL_PARENT,
	              LayoutParams.FILL_PARENT));
	    
	   
	      mChartView.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	          SeriesSelection seriesSelection = mChartView.getCurrentSeriesAndPoint();
	          if (seriesSelection == null) {

	          } else {
	            for (int i = 0; i < mSeries.getItemCount(); i++) {
	              mRenderer.getSeriesRendererAt(i).setHighlighted(i == seriesSelection.getPointIndex());
	            }
	            mChartView.repaint();
	          }
	        }
	      });
	}
	
	public void addItem(int color, int value)
	{
		 mSeries.add("SERIE", value);
		 SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
	     renderer.setColor(COLORS[color]);
	     mRenderer.addSeriesRenderer(renderer);
	}

}
