package gm.tareas.controlador;

import gm.tareas.modelo.Tarea;
import gm.tareas.servicio.TareaServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class IndexControlador implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class); //Atributo

    @Autowired
    private TareaServicio tareaServicio;

    @FXML //Es un atributo privado, entonces inidicamos que e sun componente de nuestra vista para eso usamos FXML
    private TableView<Tarea> tareaTabla;

    @FXML //Vamos a mapear las columnas
    private  TableColumn<Tarea, Integer> idTareaColumna;

    @FXML
    private TableColumn<Tarea, String> nombreTareaColumna;

    @FXML
    private TableColumn<Tarea, String> responsableColumna;

    @FXML
    private TableColumn<Tarea, String> estatusColumna;

    private final ObservableList<Tarea> tareaLista =
            FXCollections.observableArrayList(); //Una lista de tipo observable para que cualquier cambio que tengamos en esta lista se vea en nuestra lista
                //Para poder visualizarlo usamos |
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //Para que solo se pueda seleecionar un elemento de nuestra tabla
        configurarColumnas(); //metodo
    }

    private void configurarColumnas(){ //Es para poder relacionar la inf que vamos a cargar  en cada uno de los registros de nuestra tabla
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        nombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        responsableColumna.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        estatusColumna.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }
}
