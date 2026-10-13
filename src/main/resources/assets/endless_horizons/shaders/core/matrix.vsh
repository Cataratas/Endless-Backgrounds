#version 150

in vec3 Position;
in vec3 Normal;
in vec4 Color;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

out vec3 vNormal;
out vec4 vColor;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);
    vNormal = Normal;
    vColor = Color;
}
