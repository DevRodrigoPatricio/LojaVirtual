package com.br.LojaVirtual.Assembler;

import com.br.LojaVirtual.Domain.Dtos.CarrinhoComprasDTO;
import com.br.LojaVirtual.Domain.Entities.CarrinhoCompras;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarrinhoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public CarrinhoCompras modeladorEntidade(CarrinhoComprasDTO carrinhoRequisicao) {
        return modelMapper.map(carrinhoRequisicao, CarrinhoCompras.class);
    }

    public List<CarrinhoCompras> paraEntidadeColecao(List<CarrinhoComprasDTO> carrinhoRequisicaoDTO) {
        return carrinhoRequisicaoDTO.stream().map(this::modeladorEntidade)
                .collect(Collectors.toList());
    }

    public void copiaParaModelo(CarrinhoComprasDTO carrinhoprodutoDTO, CarrinhoCompras carrinhoExistente) {
        BeanUtils.copyProperties(carrinhoprodutoDTO, carrinhoExistente, "id");
    }
}

