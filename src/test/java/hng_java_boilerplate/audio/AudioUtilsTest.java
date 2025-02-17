package hng_java_boilerplate.audio;


import hng_java_boilerplate.audio.audioEnum.AudioOutput;
import hng_java_boilerplate.audio.utils.AudioUtils;
import hng_java_boilerplate.video.exceptions.JobCreationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AudioUtilsTest {

    @Test
    void testGetMatchingFormat_WithValidFormat() {
        List<AudioOutput> audioFormatList = Arrays.asList(AudioOutput.MP3, AudioOutput.WAV);

        AudioOutput result = AudioUtils.getMatchingFormat("audio/mp3", audioFormatList);

        assertNotNull(result);
        assertEquals("audio/mp3", result.getStatus());
    }

    @Test
    void testGetMatchingFormat_WithInvalidFormat() {
        List<AudioOutput> audioFormatList = Arrays.asList(AudioOutput.MP3, AudioOutput.WAV);

        Executable executable = () -> AudioUtils.getMatchingFormat("wav", audioFormatList);

        JobCreationError exception = assertThrows(JobCreationError.class, executable);
        assertEquals("output_format not supported", exception.getMessage());
    }
}
