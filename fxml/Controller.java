/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Alexander Jon
 */
public class Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private MediaView mVideo;
    private MediaPlayer mpVideo;
    private Media media;
    
    @FXML
    private VBox vBox;
    
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
    private Label totalTime;
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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        
        Image imageMute = new Image(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\mute-speaker.png").toURI().toString());
        ivMute = new ImageView(imageMute);
        ivMute.setFitHeight(IV_SIZE);
        ivMute.setFitWidth(IV_SIZE);
        
        Image imageExit = new Image(new File("C:\\Users\\Alexander Jon\\Documents\\NetBeansProjects\\XenShowsTrial\\XenApp_01\\XenShowsTrial\\src\\main\\resources\\fullscreen.png").toURI().toString());
        ivExit = new ImageView(imageExit);
        ivExit.setFitHeight(IV_SIZE);
        ivExit.setFitWidth(IV_SIZE);
        
        btnP.setGraphic(ivPause);
        volume.setGraphic(ivMute);
        speedLabel.setText("1x");
        fullScreen.setGraphic(ivFullScreen);
        
        btnP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               Button buttonPlay = (Button) event.getSource();
               if(atEndOfVideo){
                   slider.setValue(0);
                   atEndOfVideo = false;
                   isPlaying = false;
               }
               if(isPlaying){
                   btnP.setGraphic(ivPlay);
                   mpVideo.pause();
                   isPlaying = false;
               } else{
                   btnP.setGraphic(ivPause);
                   mpVideo.play();
                   isPlaying = true;
               }
            }
        });
        
        speedLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(speedLabel.getText().equals("1x")){
                    speedLabel.setText("2x");
                    mpVideo.setRate(2.0);
                }else{
                    speedLabel.setText("1x");
                    mpVideo.setRate(1.0);
                }
            }
        });
        
        volume.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(isMuted){
                    volume.setGraphic(ivVolume);
                    volumeSlider.setValue(0.2);
                    isMuted = false;
                } else{
                    volume.setGraphic(ivVolume);
                    volumeSlider.setValue(0);
                    isMuted = true;
                }
            }
        });
        
        volume.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(hBoxVolume.lookup("#volumeSlider") == null){
                    hBoxVolume.getChildren().add(volumeSlider);
                    volumeSlider.setValue(mpVideo.getVolume());
                }
            }
        });
        
        hBoxVolume.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              hBoxVolume.getChildren().remove(volumeSlider);
            }
        });
        
        vBox.sceneProperty().addListener(new ChangeListener<Scene>() {
            @Override
            public void changed(ObservableValue<? extends Scene> observable, Scene oldScene, Scene newScene) {
              if(oldScene == null && newScene != null){
                  mVideo.fitHeightProperty().bind(newScene.heightProperty().subtract(hBoxControls.heightProperty().add(20)));
              }
            }
        });
        
        fullScreen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Label label = (Label) event.getSource();
                Stage stage = (Stage) label.getScene().getWindow();
                
                if(stage.isFullScreen()){
                    stage.setFullScreen(false);
                    fullScreen.setGraphic(ivFullScreen);
                }else{
                    stage.setFullScreen(true);
                    fullScreen.setGraphic(ivExit);
                }
                stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCode() == KeyCode.ESCAPE){
                            fullScreen.setGraphic(ivFullScreen);
                        }
                    }
                });
            }
        });
        
        mpVideo.totalDurationProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldDuration, Duration newDuration) {
                slider.setMax(newDuration.toSeconds());
                totalTime.setText(getTime(newDuration));
            }
        });
        
        slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean wasChanging, Boolean isChanging) {
               if(!isChanging){
                   mpVideo.seek(Duration.seconds(slider.getValue()));
               }
            }
        });
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double currenTime = mpVideo.getCurrentTime().toSeconds();
                if(Math.abs(currenTime - newValue.doubleValue()) > 0.5){
                    mpVideo.seek(Duration.seconds(newValue.doubleValue()));
                }
                labelMatchEndVideo(currentTime.getText(), totalTime.getText());
            }
        });
        
        hBoxVolume.getChildren().remove(volumeSlider);
        
        //binding volume
        mpVideo.volumeProperty().bindBidirectional(volumeSlider.valueProperty());
        
        bindCurrentTimeLabel();
        
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mpVideo.setVolume(volumeSlider.getValue());
                if(mpVideo.getVolume() != 0.0){
                    volume.setGraphic(ivVolume);
                    isMuted = false;
                    
                } else{
                    volume.setGraphic(ivMute);
                    isMuted = true;
                }
            }
        });
    }    
    public void bindCurrentTimeLabel(){
            currentTime.textProperty().bind(Bindings.createStringBinding(new Callable<String>() {
                @Override
                public String call() throws Exception {      
                    return getTime(mpVideo.getCurrentTime());
                }
            }, mpVideo.currentTimeProperty()));

        }
            private String getTime(Duration time) {

                  int hours = (int) time.toHours();
                  int minutes = (int) time.toMinutes();
                  int seconds = (int) time.toSeconds();

                  if(seconds > 59) seconds = seconds % 60;
                  if(minutes > 59) minutes = minutes % 60;
                  if(hours > 59) hours = hours % 60;


                  if(hours > 0) return String.format("%d:%02d:%02d", hours, minutes, seconds);
                  else return String.format("%02d:%02d", minutes, seconds);

           }
            public void labelMatchEndVideo(String labelTime, String totalTime){
                   
                }
            }


