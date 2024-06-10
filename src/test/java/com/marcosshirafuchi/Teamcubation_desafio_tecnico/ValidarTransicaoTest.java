package com.marcosshirafuchi.Teamcubation_desafio_tecnico;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.TransacaoDto;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.exception.TransacaoInvalidaException;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.exception.ValidarTransacao;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.OffsetDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1> Teamcubation - Desafio Técnico</h1>
 * Desafio Técnico
 * <p>
 * <b>Note:</b> Desenvolvido na linguagem Java.
 *
 * @author  Marcos Ferreira Shirafuchi
 * @version 1.0
 * @since   09/06/2024
 */
public class ValidarTransicaoTest {


    @Test
    void testTransacaoValorNegativo() {
        // Cria uma transação com valor negativo
        Float valor =-50.0f;
        OffsetDateTime agora = OffsetDateTime.now();
        TransacaoDto transacaoValorNegativo = new TransacaoDto(valor,agora);
        transacaoValorNegativo.setValor(-50.0f);
        transacaoValorNegativo.setDataHora(OffsetDateTime.now()); // Data e hora atual

        // Cria uma instância da classe ValidarTransacao
        ValidarTransacao validarTransacao = new ValidarTransacao();

        // Testa o método validarTransacao com a transação com valor negativo
        TransacaoInvalidaException exception = assertThrows(TransacaoInvalidaException.class, () -> validarTransacao.validarTransacao(transacaoValorNegativo));
        assertEquals("O valor da transação não pode ser negativo!", exception.getMessage());
    }

    @Test
    void testTransacaoDataFutura() {
        // Cria uma transação com data futura
        Float valor =100.0f;
        OffsetDateTime duracao2minutos = OffsetDateTime.now().minus(Duration.ofMinutes(2));
        TransacaoDto transacaoDataFutura = new TransacaoDto(valor,duracao2minutos);
        transacaoDataFutura.setValor(valor);
        transacaoDataFutura.setDataHora(OffsetDateTime.now().plus(Duration.ofMinutes(2))); // Daqui a 2 minutos

        // Cria uma instância da classe ValidarTransacao
        ValidarTransacao validarTransacao = new ValidarTransacao();

        // Testa o método validarTransacao com a transação com data futura
        TransacaoInvalidaException exception = assertThrows(TransacaoInvalidaException.class, () -> validarTransacao.validarTransacao(transacaoDataFutura));
        assertEquals("Não pode colocar data futura!", exception.getMessage());
    }

    @Test
    void testTransacaoDataPassada() {
        // Cria uma transação com data passada
        Float valor =100.0f;
        OffsetDateTime duracao1Dia = OffsetDateTime.now().minus(Duration.ofMinutes(2));
        TransacaoDto transacaoDataPassada = new TransacaoDto(valor,duracao1Dia);
        transacaoDataPassada.setValor(valor);
        transacaoDataPassada.setDataHora(duracao1Dia); // Ontem

        // Cria uma instância da classe ValidarTransacao
        ValidarTransacao validarTransacao = new ValidarTransacao();

        // Testa o método validarTransacao com a transação com data passada
        TransacaoInvalidaException exception = assertThrows(TransacaoInvalidaException.class, () -> validarTransacao.validarTransacao(transacaoDataPassada));
        assertEquals("Não pode colocar data passada!", exception.getMessage());
    }
}
