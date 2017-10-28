package br.com.josemar.notepadcloud.component;

import br.com.josemar.notepadcloud.model.Nota;
import br.com.josemar.notepadcloud.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaComponent {

    @Autowired
    NotaRepository notaRepository;

    public Nota salvar(Nota nota){
        List<Nota> notas = notaRepository.findByTitulo(nota.getTitulo());
        if(notas.size()>0){
            nota.setId(notas.get(0).getId());
        }
        return notaRepository.save(nota);
    }

    public List<Nota> buscarTodos(){
        return notaRepository.findAll();
    }


    public void apagarTodos(){
        notaRepository.deleteAll();

    }

    public Nota buscarNota(String titulo){
        Nota nota;
        List<Nota> notas = notaRepository.findByTitulo(titulo);
        if(notas.isEmpty()){
            return new Nota();
        } else {
            return notas.get(0);

        }

    }

    public void apagar(String titulo){


    }


}
