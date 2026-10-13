#version 150

in vec3 vNormal;
in vec4 vColor;

uniform float GameTime;
uniform vec2 ScreenSize;

out vec4 fragColor;

void main() {
    fragColor = vec4(normalize(vColor));

}
