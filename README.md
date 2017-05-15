FXTableViewUtil
===================


I wrote FXTableViewUtil, an utility class for JavaFX to create columns easily in a TableView / Escribí FXTableViewUtil una clase para JavaFX para crear columnas en un TableView de forma sencilla.


----------
Usually to create columns in a TableView you have to code something like this:

    @FXML
        private TableView table;

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) {
            Scene scene = new Scene(new Group());
            stage.setTitle("Table View Sample");
            stage.setWidth(450);
            stage.setHeight(550);

            final Label label = new Label("Address Book");
            label.setFont(new Font("Arial", 20));

            table.setEditable(true);

            // Create Columns
            TableColumn firstNameCol = new TableColumn("First Name");
            firstNameCol.setMinWidth(100);
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

            TableColumn lastNameCol = new TableColumn("Last Name");
            lastNameCol.setMinWidth(100);
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            TableColumn emailCol = new TableColumn("Email");
            emailCol.setMinWidth(200);
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

           
            // add columns to TableView
            table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        }


As you can see you have to write several lines of code to add columns.

I wrote an utility class to create columns easly in a TableView, so now you only need to write something like this:

     @Override
        public void initialize(URL url, ResourceBundle rb) {
            tableViewUtil.createColumns(Person.class, tableView, headers, personList);
        }

---------

You can read more at http://tmsanchezdev.blogspot.mx/2017/05/fxtableviewutil-utility-class-for.html
