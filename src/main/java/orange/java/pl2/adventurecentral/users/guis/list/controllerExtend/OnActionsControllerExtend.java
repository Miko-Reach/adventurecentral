package orange.java.pl2.adventurecentral.users.guis.list.controllerExtend;

import orange.java.pl2.adventurecentral.users.enums.RoleName;
import orange.java.pl2.adventurecentral.users.guis.form.controllerExtend.FieldsControllerExtend;

public class OnActionsControllerExtend extends FieldsControllerExtend {
    protected boolean authorized = false;

    public OnActionsControllerExtend() {
        this.addOnInitializeWithSneakyThrow((resourceBundle) -> {
            this.roleCombo.getItems().addAll(RoleName.values());
            this.roleCombo.setCellFactory(new Callback<ListView<RoleName>, ListCell<RoleName>>() {
                public ListCell<RoleName> call(ListView<RoleName> p) {
                    return new ListCell<RoleName>() {
                        protected void updateItem(RoleName item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item != null && !empty) {
                                String trans = resourceBundle.getString("combo." + item.name().toLowerCase());
                                this.setText(trans);
                            } else {
                                this.setGraphic((Node)null);
                                this.setText((String)null);
                            }

                        }
                    };
                }
            });
            this.roleCombo.setButtonCell(new ListCell<RoleName>() {
                protected void updateItem(RoleName item, boolean btl) {
                    super.updateItem(item, btl);
                    if (item != null) {
                        this.setGraphic((Node)null);
                        String trans = resourceBundle.getString("combo." + item.name().toLowerCase());
                        this.setText(trans);
                    }

                }
            });
        });
        this.addOnCloseWithSneakyThrow(() -> {
            if (!this.authorized) {
                Platform.exit();
                System.exit(0);
            }

        });
    }

    @FXML
    public void cancel() {
        this.fxStage.close();
    }

    @FXML
    public void login() {
        this.sneakyThrow(() -> {
            if (LoginValidator.isValid(this.loginField.getText(), this.passwordField.getText(), (RoleName)this.roleCombo.getValue())) {
                UserGlobal.setUser(UserRepository.getByLogin(this.loginField.getText()));
                this.authorized = true;
                this.cancel();
            }

        });
    }
}
