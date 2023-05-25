package orange.java.pl2.adventurecentral.users.guis.edit.controllerExtend;

public class StageControllerExtend extends MenuPaneControllerExtend {
    protected StageControllerExtend() {
        this.addOnInitialize((resourceBundle) -> {
            Platform.runLater(() -> {
                this.fXStage.setTitle(AppManager.getDisplayName() + " - " + resourceBundle.getString("stage.title.version") + " " + AppManager.getVersion());
            });
        });
    }
}
