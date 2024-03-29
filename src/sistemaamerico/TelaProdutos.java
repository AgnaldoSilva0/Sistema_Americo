package sistemaamerico;

import Controller.TelaProdutoController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class TelaProdutos extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/TelaProduto.fxml"));
        
        Parent root = fxmlLoader.load();
        
        TelaProdutoController controller = fxmlLoader.getController();
        controller.carregarOrcamento();
        
        Scene scene = new Scene(root);
        stage.setTitle("Produtos");
        stage.getIcons().add(new Image("/Icons/logoM.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaProdutos.stage = stage;
    }
}
