/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Alexander Jon
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private MediaView mVideo;
    private MediaPlayer mpVideo;
    private Media media;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private HBox hBoxControls;
    
    @FXML
    private HBox hBoxVolume;
    
    @FXML
    private Button btnP;
    
    @FXML 
    private Label currentTime;
    @FXML 
    private Label totatTime;
    @FXML
    private Label fullScreen;
    @FXML 
    private Label speedLabel;
    @FXML
    private Label volume;
    
    @FXML
    private Slider volumeSlider;
    @FXML
    private Slider slider;
    
    private boolean atEndOfVideo = false;
    private boolean isPlaying = true;
    private boolean isMuted = true;
    
    private ImageView ivPlay;
    private ImageView ivPause;
    private ImageView ivRestart;
    private ImageView ivFullScreen;
    private ImageView ivVolume;
    private ImageView ivMute;
    private ImageView ivExit;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final int IV_SIZE = 25;
        
        media = new Media(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\SVID_20211006_172526_1.mp4").toURI().toString());
        mpVideo = new MediaPlayer(media);
        mVideo.setMediaPlayer(mpVideo);
        
        Image imagePlay = new Image(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\play-button.png").toURI().toString());
        ivPlay = new ImageView(imagePlay);
        ivPlay.setFitHeight(IV_SIZE);
        ivPlay.setFitWidth(IV_SIZE);
        
        Image imageStop = new Image(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\pause-button.png").toURI().toString());
        ivPause = new ImageView(imageStop);
        ivPause.setFitHeight(IV_SIZE);
        ivPause.setFitWidth(IV_SIZE);
        
        Image imageRestart = new Image(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\refresh.png").toURI().toString());
        ivRestart = new ImageView(imageRestart);
        ivRestart.setFitHeight(IV_SIZE);
        ivRestart.setFitWidth(IV_SIZE);
        
        Image imageVolume = new Image(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\volume-up-interface-symbol.png").toURI().toString());
        ivVolume = new ImageView(imageVolume);
        ivVolume.setFitHeight(IV_SIZE);
        ivVolume.setFitWidth(IV_SIZE);
        
        Image imageFScreen = new Image(new File("src/resources/switch-to-full-screen-button.png").toURI().toString());
        ivFullScreen = new ImageView(imageFScreen);
        ivFullScreen.setFitHeight(IV_SIZE);
        ivFullScreen.setFitWidth(IV_SIZE);
        
        Image imageMute = new Image(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\switch-to-full-screen-button.png").toURI().toString());
        ivMute = new ImageView(imageMute);
        ivMute.setFitHeight(IV_SIZE);
        ivMute.setFitWidth(IV_SIZE);
        
        Image imageExit = new Image(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\logout.png").toURI().toString());
        ivExit = new ImageView(imageExit);
        ivExit.setFitHeight(IV_SIZE);
        ivExit.setFitWidth(IV_SIZE);
        
        btnP.setGraphic(ivPause);
        volume.setGraphic(ivMute);
        speedLabel.setText("1x");
        fullScreen.setGraphic(ivFullScreen);
        
        } 
    
    }

