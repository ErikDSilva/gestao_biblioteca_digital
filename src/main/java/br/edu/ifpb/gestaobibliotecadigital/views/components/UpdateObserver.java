package br.edu.ifpb.gestaobibliotecadigital.views.components;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer para atualizações gerais
 */
public class UpdateObserver {

    private List<Listener> listeners = new ArrayList<>();

    /**
     * Adiciona um ouvinte de atualizações
     */
    public void onUpdate(Listener listener) {
        listeners.add(listener);
    }

    /**
     * Remove um ouvinte de atualizações
     */
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    /**
     * Envia um evento de atualização
     */
    public void emit() {
        for (Listener listener : listeners) {
            listener.handleUpdate();
        }
    }

    @FunctionalInterface
    public interface Listener {

        /**
         * Função que será executada quando houver uma atualização
         */
        public void handleUpdate();
    }
}
