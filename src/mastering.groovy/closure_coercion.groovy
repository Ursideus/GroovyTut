package mastering.groovy

// Coercion of closure to type
new File('/').list( { File dir, String name -> new File(name).directory } as FilenameFilter)
             .each { fileName -> println fileName }


public interface UtilityMethods {
    int[] getPositives(int... values);
    boolean isPelindrom(String str) ;
}

// map of closures coursed
UtilityMethods imp = [
        getPositives: { int... values ->
            values.findAll { it > 0 } as int[]
        },
        isPelindrom: { String string ->
            String str = string.toLowerCase().replaceAll(/\W/, '')
            str.reverse() == str
        }] as UtilityMethods

