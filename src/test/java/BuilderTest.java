import com.globant.bootcamp.weather.builder.AtmosphereBuilder;
import com.globant.bootcamp.weather.business.Atmosphere;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by maxib on 01/10/2016.
 */
public class BuilderTest {

    @Test
    public void testAtmosphereBuilder() {

        AtmosphereBuilder atmosphereBuilder = AtmosphereBuilder.anAtmosphere().withAtmosphere_id(2).
                withHumidity(3).withRising(3.0).withVisibility(4.3);

        Atmosphere atmosphere = atmosphereBuilder.build();

        assertThat(atmosphere.getHumidity(), is(equalTo(3)));
        assertThat(atmosphere.getRising(), is(equalTo(3.0)));
        assertThat(atmosphere.getVisibility(), is(equalTo(4.3)));
        assertThat(atmosphere.getAtmosphere_id(), is(equalTo(2)));
    }

}
