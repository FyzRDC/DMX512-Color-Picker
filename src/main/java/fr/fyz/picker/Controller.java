package fr.fyz.picker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {

	@FXML
	private Pane myPane;
	@FXML
	private ColorPicker picker;
	@FXML
	private Slider red_slide;
	@FXML
	private Slider green_slide;
	@FXML
	private Slider blue_slide;

	@FXML
	private Label red;
	@FXML
	private Label green;
	@FXML
	private Label blue;

	public void changeColor(ActionEvent event) {

		Color c = picker.getValue();
		int ired = (int) (c.getRed() * 255);
		int igreen = (int) (c.getGreen() * 255);
		int iblue = (int) (c.getBlue() * 255);
		red.setText("" + ired);
		red_slide.setValue(ired);
		green.setText("" + igreen);
		green_slide.setValue(igreen);
		blue.setText("" + iblue);
		blue_slide.setValue(iblue);
	}

	public void updateSlideRed(MouseEvent e) {
		double newval = red_slide.getValue();
		red.setText((int) newval + "");
		picker.setValue(new Color(newval / 255, green_slide.getValue() / 255, blue_slide.getValue() / 255, 1));
	}
	

	public void updateSlideGreen(MouseEvent e) {
		double newval = green_slide.getValue();
		green.setText((int) newval + "");
		picker.setValue(new Color(red_slide.getValue() / 255, newval / 255, blue_slide.getValue() / 255, 1));
	}

	public void updateSlideBlue(MouseEvent e) {
		double newval = blue_slide.getValue();
		blue.setText((int) newval + "");
		picker.setValue(new Color(red_slide.getValue() / 255, green_slide.getValue() / 255, newval / 255, 1));
	}
	
}