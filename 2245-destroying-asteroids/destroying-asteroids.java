class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long nmass = mass;
        for(int i = 0; i < asteroids.length; i++) {
            if(nmass < asteroids[i]) return false;
            nmass += asteroids[i];
        }

        return true;
    }
}