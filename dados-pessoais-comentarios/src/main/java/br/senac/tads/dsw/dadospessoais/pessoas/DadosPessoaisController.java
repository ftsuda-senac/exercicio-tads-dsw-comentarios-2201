package br.senac.tads.dsw.dadospessoais.pessoas;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pessoas")
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisRepository dadosPessoaisRepository;

    @GetMapping
    public ModelAndView listar() {
        List<DadosPessoais> resultados = dadosPessoaisRepository.findAll();
        ModelAndView mv = new ModelAndView("lista");
        mv.addObject("dadosLista", resultados);
        return mv;
    }

    @GetMapping("/{id}/visualizar")
    public ModelAndView visualizar(
            @PathVariable("id") Integer id,
            RedirectAttributes redirAttr) {
        Optional<DadosPessoais> optPessoa = dadosPessoaisRepository.findById(id);
        if (!optPessoa.isPresent()) {
            redirAttr.addFlashAttribute("msgErro", "Pessoa com ID " + id + " não encontrada");
            return new ModelAndView("redirect:/pessoas");
        }
        ModelAndView mv = new ModelAndView("visualizacao");
        mv.addObject("dados", optPessoa.get());
        return mv;
    }

}
