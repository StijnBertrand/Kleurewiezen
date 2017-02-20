package CardGame.flow.core;

import CardGame.state.objects.Table;

import java.util.ArrayList;

/**
 * Created by stijn on 2/18/17.
 */
public class CompositeModule extends Module {

    private ArrayList<Module> modules;

    public CompositeModule(){
        this.modules = new ArrayList();
    }

    @Override
    public void execute(Table table) {
        modules.stream().forEach(m->m.execute(table));
    }

    public void addModule(Module module){
        modules.add(module);
    }
}
