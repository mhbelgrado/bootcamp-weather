import com.globant.bootcamp.weather.builder.AtmosphereBuilder;
import com.globant.bootcamp.weather.builder.LocationBuilder;
import com.globant.bootcamp.weather.builder.WindBuilder;
import com.globant.bootcamp.weather.business.Atmosphere;
import com.globant.bootcamp.weather.business.Location;
import com.globant.bootcamp.weather.business.Wind;
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
        assertThat(atmosphere.getAtmosphereId(), is(equalTo(2)));

    }


    @Test
    public void testWindBuilder() {

        WindBuilder windBuilder = WindBuilder.aWind().withWindId(3).withDirection("Norte").withSpeed(22.2);

        Wind wind = windBuilder.build();

        assertThat(wind.getDirection(), is(equalTo("Norte")));
        assertThat(wind.getSpeed(), is(equalTo(22.2)));
        assertThat(wind.getWindId(), is(equalTo(3)));


    }

    @Test
    public void testLocationBuilder() {
        LocationBuilder locationBuilder = LocationBuilder.aLocation().withLocationId(3)
                .withCity("Cordoba").withCountry("Argentina").withRegion("NO");

        Location location = locationBuilder.build();
        assertThat(location.getCity(), is(equalTo("Cordoba")));
        assertThat(location.getCountry(), is(equalTo("Argentina")));
        assertThat(location.getLocationId(), is(equalTo(3)));
        assertThat(location.getRegion(), is(equalTo("NO")));


    }



}
