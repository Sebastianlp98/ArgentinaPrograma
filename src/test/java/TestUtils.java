import com.resultados.clases.Equipo;
import com.resultados.clases.Partido;
import com.resultados.utils.Utils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class TestUtils {

    @Test
    void csvToStringTest() {
        String datos = Utils.csvToString("src/test/resources/Pronosticos Deportivos.csv");

        Path filePath = Path.of("src/test/resources/Pronosticos Deportivos.csv");
        StringBuilder contentBuilder = new StringBuilder();

        try (
                Stream<String> stream = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {

            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (
                IOException e) {

        }

        String fileContent = contentBuilder.toString();
        Assert.assertNotNull(datos);
        Assert.assertTrue(!datos.isEmpty());
        Assert.assertEquals(datos,fileContent);

    }
    @Test
    void getPartidosTest (){

        Partido partido1 = new Partido(new Equipo("Argentina"), new Equipo("Mexico"), 2, 0);
        Partido partido2 = new Partido(new Equipo("Colombia"), new Equipo("Canada"), 2, 0);
        String datospartido = Utils.csvToString("src/test/resources/Pronosticos Deportivos.csv");
        Set<Partido> listaDePartidos1 = new HashSet<>();
        listaDePartidos1.add(partido1);
        listaDePartidos1.add(partido2);
        Set<Partido> listaDePartidos2 = Utils.getPartidos(datospartido);

        Assert.assertEquals(listaDePartidos1.toString(), listaDePartidos2.toString());
        Assert.assertNotNull(listaDePartidos2);

    }
}









