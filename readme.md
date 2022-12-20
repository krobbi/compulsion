# Compulsion
_Nitty-gritty compulsive fixes for Minecraft._  
__v1.3.2__ for Minecraft Fabric __1.19.3__  
__Copyright &copy; 2022 Chris Roberts__ (Krobbizoid)

# Contents
1. [About](#about)
2. [Downloads](#downloads)
   * [Fabric 1.19.3 Downloads](#fabric-1193-downloads)
   * [Fabric 1.19.2 Downloads](#fabric-1192-downloads)
3. [Features](#features)
   * [About Data Fixer](#about-data-fixer)
4. [Credits](#credits)
5. [License](#license)

# About
Compulsion is a Minecraft Fabric mod that aims to be updated sporadically with
minor tweaks and fixes that improve the player's experience in transparent and
subtle ways. It is the successor to
[Endfix](https://github.com/krobbi/fabricmc-endfix), my first Minecraft mod,
and contains its feature set.

The mod is dependency free and does not require any other mods, including the
Fabric API mod.

You may use this mod in mod packs without permission.

NOT AN OFFICIAL MINECRAFT PRODUCT. NOT APPROVED BY OR ASSOCIATED WITH MOJANG.

# Downloads
## Fabric 1.19.3 Downloads
* [Compulsion v1.3.2 for Minecraft Fabric 1.19.3](https://github.com/krobbi/compulsion/releases/download/v1.3.2/compulsion-1.3.2.jar)
* [Compulsion v1.3.1 for Minecraft Fabric 1.19.3](https://github.com/krobbi/compulsion/releases/download/v1.3.1/compulsion-1.3.1.jar)

## Fabric 1.19.2 Downloads
* [Compulsion v1.3.0 for Minecraft Fabric 1.19.2](https://github.com/krobbi/compulsion/releases/download/v1.3.0/compulsion-1.3.0.jar)
* [Compulsion v1.2.1 for Minecraft Fabric 1.19.2](https://github.com/krobbi/compulsion/releases/download/v1.2.1/compulsion-1.2.1.jar)
* [Compulsion v1.2.0 for Minecraft Fabric 1.19.2](https://github.com/krobbi/compulsion/releases/download/v1.2.0/compulsion-1.2.0.jar)
* [Compulsion v1.1.0 for Minecraft Fabric 1.19.2](https://github.com/krobbi/compulsion/releases/download/v1.1.0/compulsion-1.1.0.jar)
* [Compulsion v1.0.0 for Minecraft Fabric 1.19.2](https://github.com/krobbi/compulsion/releases/download/v1.0.0/compulsion-1.0.0.jar)

For more information, see the [GitHub releases page](https://github.com/krobbi/compulsion/releases).

# Features
* Fix the positioning of newly generated End gateways.
* Fix the positioning of newly generated End spikes.
* Display End portal blocks on all sides with the correct height.
* Disable data fixer optimization. (See [About Data Fixer](#about-data-fixer).)
* Disable telemetry.

## About Data Fixer
The data fixer is a component of the game that helps convert the format of
external data (worlds etc.) when updating to new versions. When the game boots,
the rules used by the data fixer are optimized. This is quite a heavy process
that can slow down booting significantly. Depending on your device, this may
cause up to several minutes of lag after the game starts.

Normally, the data fixer is rarely used, so this optimization step is skipped.
Because of this, converting worlds may be slower, and you may initially
experience lag spikes when playing in older worlds.

# Credits
Logo color palette - [Faraway48](https://lospec.com/palette-list/faraway48) by
[Igor Ferreira](https://diemorth.github.io/diemorth).

# License
Compulsion is released under the MIT License:  
https://krobbi.github.io/license/2022/mit.txt

See [license.txt](./license.txt) for a full copy of the license text.
